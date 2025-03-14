import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './index.css'
import Login from './components/Login'
import Register from './components/Register';
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom'
import Home from './components/Home'

function App() {
  
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/' element = {<Login/>}/>
      <Route path='/register' element = {<Register/>}/>
    </Routes>
    </BrowserRouter>
  )
}

export default App
