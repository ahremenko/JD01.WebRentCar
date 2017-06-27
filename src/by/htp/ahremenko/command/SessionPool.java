package by.htp.ahremenko.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SessionPool {
	
	private final int MAX_SESSIONS = 100;
	private static final SessionPool instance = new SessionPool();
	private Map<String, Integer> sessions;
	
	private SessionPool() {
		this.sessions = new HashMap<>();
	}
	
	public static SessionPool getInstance() {
		return instance;
	}
	
	public String addNewSession( Integer userId) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append("rcsi");
		sb.append(rnd.nextInt(10000000));
		String sessionId = sb.toString();
		this.sessions.put(sessionId, userId);
		return sessionId;
	}
	
	public int getUserIdBySessionId (String sessionId) {
		Integer userId = this.sessions.get(sessionId);
		return userId;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<String, Integer>> set = this.sessions.entrySet();
		for (Map.Entry<String, Integer> me : set) {
			sb.append(me.getKey() + ": " + me.getValue() );
		}
		return sb.toString();
	}
}
