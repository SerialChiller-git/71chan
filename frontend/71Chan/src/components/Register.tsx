import React, { use, useState } from "react";
import { register } from "../../services/authsService";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const[username, setUsername] = useState('');
  const[email,setEmail] = useState('');
  const[password,setPassword] = useState('');
  const navigate = useNavigate();
  const handleRegister = async () => {
    const data = {
        username: username,
        email: email,
        password: password
    }
    const response = await register(data);
    console.log(response);
    if(response == "User registered successfully"){
        navigate("/login");
    }
    else{
        console.log(response);
    }
  }
  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-blue-600 to-indigo-800 p-4">
      <div className="w-full max-w-md bg-white/10 backdrop-blur-md rounded-xl p-8 shadow-lg text-white">
        <h2 className="text-3xl font-bold text-center mb-6">Welcome</h2>

        <form className="space-y-4">
        <div>
            <label className="block text-gray-200 mb-1">Username</label>
            <input
              
              value={username}
              onChange={(event) => setUsername(event.target.value)}
              placeholder="Enter your username"
              className="w-full px-4 py-2 bg-white/20 text-white placeholder-gray-300 rounded-lg border border-white/30 focus:ring-2 focus:ring-blue-400 focus:outline-none"
            />
          </div>
       
          <div>
            <label className="block text-gray-200 mb-1">Email</label>
            <input
              type="email"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
              placeholder="Enter your email"
              className="w-full px-4 py-2 bg-white/20 text-white placeholder-gray-300 rounded-lg border border-white/30 focus:ring-2 focus:ring-blue-400 focus:outline-none"
            />
          </div>

       
          <div>
            <label className="block text-gray-200 mb-1">Password</label>
            <input
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              className="w-full px-4 py-2 bg-white/20 text-white placeholder-gray-300 rounded-lg border border-white/30 focus:ring-2 focus:ring-blue-400 focus:outline-none"
            />
          </div>

       
          <button onClick={handleRegister} className="w-full bg-blue-500 hover:bg-blue-600 transition-all py-2 rounded-lg text-white font-semibold">
            Sign Up
          </button>
        </form>
      </div>
    </div>
  );
};

export default Register;
