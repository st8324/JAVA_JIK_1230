import { Button1, Button2, Button } from "./Button";

function PropsSample(){
	return (
    <div>
      <Button1 text={"버튼1"} />
      <Button2 text={"버튼2"} />
      <Button1 text={"버튼3"} />
      <Button2 text={"버튼4"} />
      <Button text={"버튼5"} style={{color : "red", backgroundColor:"#fff"}} />
      <Button />
    </div>
  );
}

export default PropsSample;