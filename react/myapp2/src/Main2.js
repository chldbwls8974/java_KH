import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Main2(){
  let [id, setId] = useState(''); 
  let [pw, setPw] = useState(''); 

  const idChange =(e)=> setId(e.target.value);
  const pwChange=(e)=>  setPw(e.target.value);
  // 보낼 땐 navigate
  const navigate = useNavigate();
  const sendData = ()=>{
    navigate('/menu3',{
      state:{
        id:id,
        pw:pw
      }
    })
  }
    return(
      <main>
        <h2>메인2</h2>
        <input type="text" onChange={idChange} value={id} placeholder="아이디"/><br/>
        <input type="password" onChange={pwChange} value={pw} placeholder="비번"/><br/>
        <button onClick={sendData}>Main3에 전송</button>
      </main>
    )
  }

  export default Main2;