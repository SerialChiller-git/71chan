import logo from './logo.svg';
import './App.css';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
function App() {
  return (
    <Router>
      <div className='container'>
        <Routes>
          <Route path = "/" element = {<LoginPage />} />
          <Route path ="/register" element = {<RegisterPage/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
