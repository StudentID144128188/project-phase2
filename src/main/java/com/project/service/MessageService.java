package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Message;
import com.project.repository.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	public List<Message> getAllMessages(){
		List<Message> messages = new ArrayList<Message>();
		messages = messageDao.findAll();
		return messages;
	}
	
	public Message getMessageById(String messageId){
		Optional<Message> msg = messageDao.findById(messageId);
		if(msg.isPresent()) {
			return msg.get();
		}else {
			return null;
		}
	}
	
	public Message createMessage(Message message) {
		messageDao.save(message);
		return message;
	}
	
	public Message updateMessage(String messageId, Message message) {
		message.setId(messageId);
		return messageDao.save(message);
	}
	
	public void deleteMessage(String messageId) {
		messageDao.deleteById(messageId);
	}

}
