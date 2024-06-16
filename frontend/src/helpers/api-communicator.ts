import axios from "axios";
import { SetStateAction } from "react";
import { Message } from "../pages/Chat";

const mockUsers = [
  {
    email: "mockUser1@example.com",
    password: "1234",
    name: "mockUser1",
  },
  {
    email: "mockUser2@example.com",
    password: "1234",
    name: "mockUser2",
  },
  {
    email: "mockUser3@example.com",
    password: "1234",
    name: "mockUser3",
  },
];

const mockChats: SetStateAction<Message[]> = [
  { role: "user", content: "Hello" },
  { role: "assistant", content: "Hi" },
];

export const loginUser = async (email: string, password: string) => {
  // const res = await axios.post("/user/login", { email, password });
  let res = { status: 401, data: { email: "", name: "" } };
  mockUsers.forEach((user) => {
    if (user.email === email && user.password === password) {
      res.status = 200;
      res.data = {
        email: user.email,
        name: user.name,
      };
    }
  });

  if (res.status !== 200) {
    throw new Error("Unable to login");
  }
  const data = await res.data;
  return data;
};

export const signupUser = async (
  name: string,
  email: string,
  password: string
) => {
  // const res = await axios.post("/user/signup", { name, email, password });
  const res = { status: 201, data: { email, name } };
  if (res.status !== 201) {
    throw new Error("Unable to Signup");
  }
  const data = await res.data;
  return data;
};

export const checkAuthStatus = async () => {
  // const res = await axios.get("/user/auth-status");
  const res = { status: 200, data: { email: "", name: "thisShouldBeCurrentName" } };
  if (res.status !== 200) {
    throw new Error("Unable to authenticate");
  }
  const data = await res.data;
  return data;
};

export const sendChatRequest = async (message: string, image: string | null) => {
  // const res = await axios.post("/chat/new", { message });
  const updatedChats = [...mockChats, { role: "user", content: message, image: image }, { role: "assistant", content: "Here you go!", image: "./gt.png" }];
  const res = { status: 200, data: { chats: [...updatedChats] } };
  if (res.status !== 200) {
    throw new Error("Unable to send chat");
  }
  const data = await res.data;
  return data;
};

export const getUserChats = async () => {
  // const res = await axios.get("/chat/all-chats");
  const res = { status: 200, data: { chats: [...mockChats] } };

  if (res.status !== 200) {
    throw new Error("Unable to send chat");
  }
  const data = await res.data;
  return data;
};

export const deleteUserChats = async () => {
  // const res = await axios.delete("/chat/delete");
  const res = { status: 200, data: { chats: [] } };
  if (res.status !== 200) {
    throw new Error("Unable to delete chats");
  }
  const data = await res.data;
  return data;
};

export const logoutUser = async () => {
  const res = await axios.get("/user/logout");
  if (res.status !== 200) {
    throw new Error("Unable to delete chats");
  }
  const data = await res.data;
  return data;
};
