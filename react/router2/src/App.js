import {BrowserRouter, Link, Route, Routes} from 'react-router-dom'
import Main from './Main';
import PostList from './PostList';
import PostInsert from './PostInsert';

function App() {
  

  return (
    <BrowserRouter>
      <nav>
        <ul>
          <li>
            <Link to={"/"}>메인</Link>
          </li>
          <li>
            <Link to={"/post/list/0"}>게시글 목록</Link>
          </li>
          <li>
            <Link to={"/post/insert"}>게시글 등록</Link>
          </li>
        </ul>
      </nav>
      <Routes>
        <Route path='/' exact element={<Main/>} />
        <Route path='/post/list/:num' element={<PostList/>} />
        <Route path='/post/insert' element={<PostInsert/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
