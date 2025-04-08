import { useState } from "react";

function MapSample(){
	let titles = ["아침", "점심", "저녁", "간식"];
	return (
		<div>
			<ul>
				{
					titles.map((v, i, arr)=>{
						return <li key={i}>{v}</li>
					})
				}
			</ul>
		</div>
	)
}

export default MapSample;