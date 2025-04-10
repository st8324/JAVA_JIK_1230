import {BrowserRouter, Link, Route, Routes} from 'react-router-dom'
import Main from './Main';
import PostList from './PostList';
import PostInsert from './PostInsert';
import Nav from './Nav';
import PostDetail from './PostDetail';
import Signup from './Signup';

function App() {
  

  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route path='/' exact element={<Main/>} />
        <Route path='/post/list/:num' element={<PostList/>} />
        <Route path='/post/detail/:num' element={<PostDetail/>} />
        <Route path='/signup' element={<Signup/>} />
        {/* <Route path='/post/insert' element={<PostInsert/>} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
