import { Link } from "react-router-dom";


function Header(){
	return (
		<header>
			<nav className="navbar navbar-expand-sm bg-dark navbar-dark">
				<Link className="navbar-brand" to={"/"}>
					<img src="logo.png" alt="Avatar Logo" style={{width:"40px"}} className="rounded-pill"/> 
				</Link>
				<div className="collapse navbar-collapse" id="collapsibleNavbar">
					<ul className="navbar-nav">
						<li className="nav-item">
							<Link to={"/post/list/0"} className="nav-link">게시글 목록</Link>
						</li>
					</ul>
				</div>
			</nav>
		</header>
	)
}

export default Header;