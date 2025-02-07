package com.poly.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface MailService {
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Mail {
		@Default
		private String from = "huybttps40336@gmail.com";
		private String to, cc, bcc, subject, body, filenames;
	}

	void send(Mail mail);

	default void send(String to, String subject, String body) {
		Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
		this.send(mail);
	}

	void push(Mail mail);

	default void push(String to, String subject, String body) {
		this.push(Mail.builder().to(to).subject(subject).body(body).build());
	}
}
