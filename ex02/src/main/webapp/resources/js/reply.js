	let replyService = (function(){
			 function add(callback, error){
				$.ajax({
					url: "../reply/",
					method:"post",
					data:$("#replyForm").serialize(),
					dataType:"json",
					success:function (data){
						if(callback) callback(data);
					},
					error:function(){
						if(error) error();
					}
				});
			 }
			 //목럭
			 function getList(param, callback,error){
					$.ajax({
					url: "../reply/",
					data:param,
					dataType:"json",
					success:function (data){
						if(callback) callback(data);
					},
					error:function(){
						if(error) error();
					}
				});
			 }
			 return {add:add, getList:getList}
		 })();
	