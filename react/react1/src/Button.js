import PropTypes from 'prop-types';

function Button1(props){
	return(
		<button>{props.text}</button>
	);
}
function Button2({text}){
	return(
		<button>{text}</button>
	);
}
function Button({text = "버튼", style, click}){
	return(
		<button style={style} onClick={click}>{text}</button>
	);
}

Button.propTypes = {
	text : PropTypes.string,
	style : PropTypes.object
}


export {Button1, Button2, Button};