package edu.bu.met.cs665.bookstore;

import java.util.ArrayList;
import java.util.List;

public class RejectionEmail {

	private List<CommandCheck> list = new ArrayList<CommandCheck>();
	
	public void execute(CommandCheck command) {
		this.list.add(command);
		command.generate();
	}
}