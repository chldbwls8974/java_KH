import { useState } from "react";

function Input({inputEvent}){
  
    return(
      <input onChange={inputEvent}/>
    )
  }

  export default Input;