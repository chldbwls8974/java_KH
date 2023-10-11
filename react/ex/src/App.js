import Btn from "./Btn"
import { useState } from "react";
import Input from "./Input";
import Main from "./Main";
import Login from "./Login";
import {Routes, Route, Link} from 'react-router-dom';


function App() {
 
  let [count, setCount] = useState(0);
  let [text, setText] = useState('');
  let[sendText, setSendText] = useState('');
  
  const onClick =()=>{
    setSendText(text);
  }

  const clickEvent =()=>{
    setCount(++count);
    console.log(count)
  }

  const inputChange = (e) =>{
    setText(e.target.value)
  }
  console.log('input:', text)

  return (
    <div>
      <Btn text="버튼1" effect={clickEvent}/>
      <Btn text="버튼2" effect={clickEvent}/>
      <Btn text="버튼3" effect={clickEvent}/><br/>
      <Input inputEvent={inputChange} value={text}/>
      <button onClick={onClick}>전송</button>
      <h1>{sendText}</h1>
      <ul>
        <li>
          <Link to="/">홈</Link>
        </li>
        <li>
          <Link to="/login">로그인</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" exact element={ <Main/>} />
        <Route path="/login" element={<Login/>} />
      </Routes>
    </div>
  );
}

export default App;
