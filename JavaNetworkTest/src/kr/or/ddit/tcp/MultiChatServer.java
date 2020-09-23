package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {
	// 대화명, 클라이언트의 Socket을 저장하기 위한 Map변수 선언
	Map<String, Socket> clients;
	
	// 생성자
	public MultiChatServer() {
		// 동기화 처리가 가능하도록 Map객체 생성
		clients = Collections.synchronizedMap(new HashMap<String, Socket>());
	}
	
	// 비지니스 로직을 처리하는 메서드 (서버시작)
	public void serverStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				//클라이언트 접속을 대기한다. .accept();
				socket = serverSocket.accept();
				
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()
									+"] 에서 접속하였습니다.");
				//메시지 전송 처리를 하는 스레드 생성 및 실행
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//서버소켓 닫기
			if(serverSocket != null) {
				try {serverSocket.close();}catch (IOException e) {}
			}
		}
	}
	
	// 대화방 즉, Map에 저장된 전체 유저에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {
		// Map에 저장된 유저의 대화명 리스트 추출(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				String name = it.next(); // 대화명(key값 구하기)
				
				// 대화명에 해당하는 Socket의 OutputStream객체 구하기
				DataOutputStream dos = new DataOutputStream(clients.get(name).getOutputStream());
				
				dos.writeUTF(msg); // 메시지 보내기
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	// 서버에서 클라이언트로 메시지를 전송할 Thread클래스를 Inner클래스로 정의 
	// Inner클래스에서는 부모 클래스의 멤버들을 직접 사용할 수 있다. 
	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream dis;
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String name = "";
			try {
				//서버에서는 클라이언트가 보내는 최초의 메시지 즉, 대화명을 수신해야한다.
				//상대방이 보낸문자를 무조건 한번 읽는다. 처음은 무조건 대화명을 보내게 만들었기 때문에 읽는 것은 대화명.
				name = dis.readUTF(); // 메시지전송받기 전까지 블락된다.
				
				//대화명을 받아서 다른 모든 클라이언트에게 대화방 참여 메시지를 보낸다.
				sendToAll("#"+name+"님이 입장했습니다.");
				
				//대화명과 소켓정보를 Map에 저장한다. why? 처음들어온 사용자니까 정보 저장해야지.
				clients.put(name, socket);
				System.out.println("현재 서버 접속자 수는 "+clients.size()+"명 입니다.");
				
				//이 후의 메시지 처리는 반복문으로 처리한다. 
				//한 클라이언트가 보낸 메시지를 다른 모든 클라이언트에게 보내준다. 
				while(dis != null) {
					sendToAll(dis.readUTF());
				}
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				//이 finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다. 
				sendToAll(name+"님이 나가셨습니다.");
				
				//Map에서 해당 대화명을 삭제한다.
				clients.remove(name);
				
				System.out.println("["+socket.getInetAddress()+" : "+socket.getPort()+"] 에서 접속을 종료했습니다.");
				System.out.println("현재 접속자 수는 "+clients.size()+"명 입니다.");
			}
		}

	}
	
	public static void main(String[] args) {
		new MultiChatServer().serverStart();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
