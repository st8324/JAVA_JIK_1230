import { Link } from "react-router-dom";

function Nav(){
	return(
		<nav className="navbar navbar-expand-sm bg-dark navbar-dark">
			<div className="container">
				<button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
					<span className="navbar-toggler-icon"></span>
				</button>
				<div className="collapse navbar-collapse" id="collapsibleNavbar">
					<ul className="navbar-nav">
						<li className="nav-item">
							<Link className="nav-link" to={"/"}>메인</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link" to={"/post/list/0"}>게시글 목록</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link" to={"/post/insert"}>게시글 등록</Link>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	)
}

export default Nav;