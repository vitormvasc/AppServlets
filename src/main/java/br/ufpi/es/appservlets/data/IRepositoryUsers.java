package br.ufpi.es.appservlets.data;

import java.util.List;
import br.ufpi.es.appservlets.entities.*;

public interface IRepositoryUsers {
	public void insert(User u);
	public List<User> list();
	public User search(String login, String password);
	public void edit(User original, User new_user);
	public void remove(User u);
	public List<User> searchByContentAndType(String content, String type);
}