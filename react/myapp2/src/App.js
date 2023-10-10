import Header from "./Header";
import Main from "./Main";
import Footer from "./Footer";

function App() {
  // function은 return 컴포넌트를 필요로 함. 
  // 컴포넌트는 부모가 하나여야함.
  return (
    <div className="App">
      <Header/>
      <Main/>
      <Footer/>
    </div>
  );
}


// 함수를 만들면 반드시 export 를 통해서 밖에서 사용할 수 있다.
export default App;
