package jp.co.ocp.sample.spring_session.controller;

import java.io.Serializable;

import lombok.Data;

@Data
public class WelcomeForm implements Serializable {

	private String input = "default";
}
