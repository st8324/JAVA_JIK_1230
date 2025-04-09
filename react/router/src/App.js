import {BrowserRouter, Link, Route, Routes} from 'react-router-dom';
import Main from './Main';
import Page2 from './Page2';
import Page1 from './Page1';
import { useState } from 'react';

function App() {
  let [list, setList] = useState([
    {
      num : 3,
      title : "공지3",
      writer : "admin",
      view : 0,
      content : "공지사항3입니다."
    },
    {
      num : 2,
      title : "공지2",
      writer : "admin",
      view : 10,
      content : "공지사항2입니다."
    },
    {
      num : 1,
      title : "공지1",
      writer : "admin",
      view : 20,
      content : "공지사항1입니다."
    }
  ])
  function addPost(obj){
    if(list.length == 0){
      obj.num = 1;
    }else{
      obj.num = list[0].num + 1;
    }
    obj.view = 0;
    setList([obj, ...list]);
  }
  return (
    <BrowserRouter>
      <nav>
        <ul>
          <li>
            <Link to="/">메인</Link>
          </li>
          <li>
            <Link to="/page1">게시글 목록</Link>
          </li>
          <li>
            <Link to="/page2">페이지2</Link>
          </li>
        </ul>
      </nav>
      <Routes>
        <Route path={"/"} exact element={<Main/>} />
        <Route path={"/page1"} element={<Page1 list={list} />} />
        <Route path={"/page2"} element={<Page2 func={addPost} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
