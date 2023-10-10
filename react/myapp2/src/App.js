import Header from "./Header";
import Main from "./Main";
import Main2 from "./Main2";
import Main3 from "./Main3";
import Footer from "./Footer";
import {BrowserRouter, Route, Routes} from "react-router-dom"

function App() {
  // function은 return 컴포넌트를 필요로 함. 
  // 컴포넌트는 부모가 하나여야함.
  return (
    <BrowserRouter>
      <div className="App">
        <Header/>
        <Routes>
          <Route path="/" exact element={<Main/>}></Route>
          <Route path="/menu2" exact element={<Main2/>}></Route>
          <Route path="/menu3" exact element={<Main3/>}></Route>
        </Routes>
        <Footer/>
      </div>
    </BrowserRouter>
  );
}


// 함수를 만들면 반드시 export 를 통해서 밖에서 사용할 수 있다.
export default App;
