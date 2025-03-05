import 'bootstrap/dist/css/bootstrap.min.css';
import AuthServices from '../AuthServices';
import React, { userState, useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';


const RegisterPage = () =>{
    const [userName, setUserName] = useState("");
    const [passWord, setPassWord] = useState("");
    const [email, setEmail] = useState("");
    const navigate = useNavigate();
    const [message, setMessage] = useState("");


const handleRegister = async (e) => {
    try{
        const response = await AuthServices.register(userName, email, passWord);
        setMessage(response.data);
        if(response == "User registered successfully"){
            navigate("/login");
        }
    }
    catch(error){
        setMessage("Registration Failed");
    }
};

return(
  <div className="min-h-screen bg-[#EEE] flex items-center justify-center p-4">
  <div className="bg-[#FFF] p-6 border border-gray-400 w-96 text-center shadow-md">
    <h1 className="text-xl font-bold mb-4">71chan Registration</h1>
    <form onSubmit={handleRegister} className="space-y-4">
      <input
        type="text"
        placeholder="Username"
        value={userName}
        onChange={(e) => setUserName(e.target.value)}
        className="w-full p-2 border border-gray-400 bg-[#F8F8F8] text-sm"
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        className="w-full p-2 border border-gray-400 bg-[#F8F8F8] text-sm"
      />
      <input
        type="password"
        placeholder="Password"
        value={passWord}
        onChange={(e) => setPassWord(e.target.value)}
        className="w-full p-2 border border-gray-400 bg-[#F8F8F8] text-sm"
      />
      <button
        type="submit"
        className="w-full bg-[#D6D6D6] p-2 border border-gray-500 hover:bg-gray-300 text-sm"
      >
        Register
      </button>
    </form>
  </div>
</div>
);


};

export default RegisterPage;


