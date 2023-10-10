import './App.css';
import Menu from './Menu.js';
import Footer from './Footer.js';
import Body from './Body.js';





function App() {
  return (
  <div>
    <div>
       <Menu/>
        <Menu/>
        <Menu/>
        <Body/>
        <Footer/>
    </div> 
  </div>
    
  );
}

// 위에서 만든 컴포넌트를 내보내는 기능
export default App;
