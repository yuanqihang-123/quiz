import React, { Component } from 'react';
import './Product.css'

class Product extends Component {

    handleClick = async (product) => {
        document.getElementById("add").disabled=true;
        const id = product.id;
        //发送请求到后端，添加商品到订单
        const response = await fetch('http://localhost:8080/order/' + id);
        document.getElementById("add").disabled=false;
        if (response.status == 201) {
            alert("创建成功！")
        }
    };

    render() {
        return (
            <div className="product_div">
                <img src={this.props.product.url} alt="商品" className="product_img"/>
                <div>
                    {this.props.product.name}
                </div>
                <div>
                    单价:{this.props.product.price}元/{this.props.product.unit}
                </div>
                <div className="div_plus">
                    <input
                        id="add"
                        type='button'
                        value="+"
                        // onClick={()=> this.props.handleClick(this.props.product)}
                        onClick={()=> this.handleClick(this.props.product)}
                    />
                </div>
            </div>
        );
    }
}

export default Product;
