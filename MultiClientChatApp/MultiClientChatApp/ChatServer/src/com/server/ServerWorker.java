package com.server;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ServerWorker extends Thread {

    private final Socket clientSocket;
    private final Server server;
    private String login = null;
    private OutputStream outputStream;

    public ServerWorker(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void run(){
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleClientSocket() throws IOException, InterruptedException {
        InputStream inputStream = clientSocket.getInputStream();
        this.outputStream = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) !=null){
            String[] tokens = StringUtils.split(line);
                if(tokens !=null && tokens.length>0) {
                    String cmd = tokens[0];
                    if ("logoff".equals(cmd) || "bye".equalsIgnoreCase(cmd)) {
                       handLogoff();
                        break;
                    }else if("login".equalsIgnoreCase(cmd)){
                        handleLogin(outputStream,tokens);
                    }else if ("msg".equalsIgnoreCase(cmd)){
                        String[] tokensMsg = StringUtils.split(line,null,3);
                        handleMessage(tokensMsg);
                    } else {
                        String msg = "Unknown "+ cmd+"\n";
                        outputStream.write(msg.getBytes());
                    }

                }
        }
        clientSocket.close();
    }

    //format: "msg" "login" body..
    private void handleMessage(String[] tokens) throws IOException {
        String sendTo =tokens[1];
        String body = tokens[2];

        List<ServerWorker> workerList = server.getWorkerList();
        for (ServerWorker worker:workerList){
            if (sendTo.equalsIgnoreCase(worker.login)){
                String outMsg = "msg "+login+" "+body+"\n";
                worker.send(outMsg);
            }
        }

    }

    private void handLogoff() throws IOException {
        server.removeWorker(this);
        List<ServerWorker> workerList = server.getWorkerList();
        String onlineMsg = "Offline "+login+"\n";
        for (ServerWorker worker:workerList){
            if (!login.equals(worker.getLogin())) {
                worker.send(onlineMsg);
            }
        }
        clientSocket.close();
    }

    public String getLogin() {
        return login;
    }

    private void handleLogin(OutputStream outputStream, String[] tokens) throws IOException {
        if (tokens.length==3){
            String login =tokens[1];
            String passWord = tokens[2];

            if ((login.equals("user") && passWord.equals("user")) ||(login.equals("abhi") && passWord.equals("abhi")) ||(login.equals("ab") && passWord.equals("ab"))){
                String msg = "login ok \n";
                outputStream.write(msg.getBytes());
                this.login = login;
                System.out.println("user logged success: " + login);


                List<ServerWorker> workerList = server.getWorkerList();
                for (ServerWorker worker:workerList){

                        if (worker.getLogin() != null){
                            if (!login.equals(worker.getLogin())) {
                                String msg2 = "online " + worker.getLogin() + "\n";
                                send(msg2);
                            }
                        }
                    }

                String onlineMsg = "Online "+login+"\n";
                for (ServerWorker worker:workerList){
                    if (!login.equals(worker.getLogin())) {
                        worker.send(onlineMsg);
                  }
                }
            }else{
                String msg = "login error \n";
                outputStream.write(msg.getBytes());
            }
        }
    }

    private void send(String msg) throws IOException {
       if (login !=null)
           outputStream.write(msg.getBytes());
    }
}
