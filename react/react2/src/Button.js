
function Button({click, className, text="버튼"}){
	
	return (
		<button onClick={click} className={className} >{text}</button>
	);
}

export default Button;