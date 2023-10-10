import { useState } from "react";
import { useLocation } from "react-router-dom";

function Main3(){
  let [id, setId] = useState(''); 
  let [pw, setPw] = useState(''); 
  // 받을 땐 location
  const location = useLocation();

  if(location.state !=null ){
  let tmpId = location.state.id;
  let tmpPw = location.state.pw;
  if(location.state!=null){
    setId(tmpId);
    setPw(tmpPw);
  }
  location.state=null;  
  }
    return(
      <main>
        <h2>메인3</h2>
        <h3>ID: {id}</h3>
        <h3>PW: {pw}</h3>
      </main>
    )
  }

  export default Main3;