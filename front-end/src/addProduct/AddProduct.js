import React, {Component, Fragment} from 'react';
import './AddProduct.css'

class AddProduct extends Component {

    state = {
        products: []
    };


    handleSubmit = (e) => {
        e.preventDefault()
        if (document.getElementById("name").value === "" ||
            document.getElementById("price").value === "" ||
            document.getElementById("unit").value === "" ||
            document.getElementById("url").value === "" ){
            alert("请输入所有值！")
            return;
        }
        const obj = [
            document.getElementById("name").value,
            document.getElementById("price").value,
            document.getElementById("unit").value,
            document.getElementById("url").value,
        ]
        var httpRequest = new XMLHttpRequest();//第一步：创建需要的对象
        httpRequest.open('POST', 'http://localhost:8080/product/', true); //第二步：打开连接/***发送json格式文件必须设置请求头 ；如下 - */
        httpRequest.setRequestHeader("Content-type","application/json");//设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）var obj = { name: 'zhansgan', age: 18 };
        httpRequest.send(JSON.stringify(obj));//发送请求 将json写入send中

        httpRequest.onreadystatechange = function () {//请求后的回调接口，可将请求成功后要执行的程序写在其中
            if (httpRequest.readyState == 4 && httpRequest.status == 200) {//验证请求是否发送成功
                var json = httpRequest.responseText;//获取到服务端返回的数据
                if (json === "repeat"){
                    alert("商品已存在！请输入新商品名")
                }else {
                    alert("添加成功！")
                }
            }
        };


    }


    render() {
        return (
            <div className="products_div">
                <form onSubmit={this.handleSubmit}>

                <label htmlFor="name">名称</label>
                <input type="text" name="name" id="name"/>
                <br/>
                <label htmlFor="price">价格</label>
                <input type="text" name="price" id="price"/>
                <br/>
                <label htmlFor="unit">单位</label>
                <input type="text" name="unit" id="unit"/>
                <br/>
                <label htmlFor="url">图片</label>
                <input type="text" name="url" id="url"/>
                <br/>
                <button type="submit" >确定</button>
                {/*<input type="submit" value="提交" onClick={(event)=>{this.handleClick(event)}}/>*/}
                </form>
            </div>
        );
    }
}

export default AddProduct;
