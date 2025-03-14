import React, { use, useState } from "react";
import { Link } from "react-router-dom";
import {login} from '../../services/authsService';
const Login = () => {
  const[email,setEmail] = useState('');
  const[password,setPassword] = useState('');
  const handleLogin = async () => {
    const user = { 
        email: email,
        password: password
    }
    const response = await login(user);
    console.log(response);
  }
  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-blue-600 to-indigo-800 p-4">
      <div className="w-full max-w-md bg-white/10 backdrop-blur-md rounded-xl p-8 shadow-lg text-white">
        <h2 className="text-3xl font-bold text-center mb-6">Welcome Back</h2>
        <p className="text-gray-300 text-center mb-6">
          Please enter your credentials to continue.
        </p>

        <form className="space-y-4">
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


          <button onClick = {handleLogin} className="w-full bg-blue-500 hover:bg-blue-600 transition-all py-2 rounded-lg text-white font-semibold">
            Sign In
          </button>
        </form>


        <div className="flex items-center my-4">
          <div className="flex-1 border-t border-white/30"></div>
          <span className="px-2 text-sm text-gray-300">or</span>
          <div className="flex-1 border-t border-white/30"></div>
        </div>


        <p className="text-center text-gray-300 mt-4">
          Don't have an account?{" "}
          <Link to={'/register'} className="text-blue-300 hover:underline">
            Sign Up
          </Link>
        </p>
      </div>
    </div>
  );
};

export default Login;
