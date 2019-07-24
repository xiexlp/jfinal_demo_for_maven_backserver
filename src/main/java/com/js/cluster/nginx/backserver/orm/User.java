package com.js.cluster.nginx.backserver.orm;

public class User implements Comparable<User>{

    long userId;

    String userName;
    
    int age;

    public User buildUserId(long userId){
        this.userId = userId;
        return this;
    }

    public User buildUserName(String userName){
        this.userName = userName;
        return this;
    }

    public User buildAge(int age){
        this.age = age;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


    @Override
    public int compareTo(User o) {
        if(age < o.age){
            return -1;
        }
        if(age > o.age){
            return 1;
        }
        if(age == o.age){
//            if(uid < o.uid){
//                return -1;
//            }
//            if(uid > o.uid){
//                return 1;
//            }
            return 0;
        }
        return 0;
    }
}
