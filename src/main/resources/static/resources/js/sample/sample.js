"use strict";

$(()=>{
	new Sample();
	console.log("test");
	console.log("test");
})

export class Sample{
	constructor() {
		this.eventBind();
		var template = require('art-template');
		var html = template("test", {
			user: {
				name: 'aui'
			}
		});
		document.getElementById('test').innerHTML = html;
	}

	eventBind(){
		$('.base_info').on('click', (e)=>{
			console.log('aaa');
			location.href='/join';
		})

		$('#data > span').on('click', (e)=>{
			console.log('eeee')
			console.log('eeeeddd')
			console.log(e);
		})
	}

}