package com.toplong.perfectparents.app;

import android.app.Application;

import com.toplong.perfectparents.entity.User;

public class PerfectParents extends Application{
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
}
