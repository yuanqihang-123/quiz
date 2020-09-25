import React, {Component, Fragment} from 'react';
import './Order.css'

class Order extends Component {

    state = {
        Orders: []
    };

    handleClick = async (id) => {
        const response = await fetch('http://localhost:8080/order?id=1');
        if (response.status == 204) {
            alert("删除成功成功！")
        }
    };

    async componentDidMount() {
        const response = await fetch('http://localhost:8080/orders');
        const json = await response.json();
        this.setState({
            Orders: json,
        })
    };

    render() {
        return (
            <div className="order_div">
                <div>
                    <input type='button' readOnly value="名字"/>
                    <input type='button' readOnly value="单价"/>
                    <input type='button' readOnly value="数量"/>
                    <input type='button' readOnly value="单位"/>
                    <input type='button' readOnly value="操作"/>
                </div>
                {
                    this.state.Orders.map((item, index) => {
                        return <div key={index}>
                            <input type='button' readOnly value={item.ProductEntity.name} />
                            <input type='button' readOnly value={item.ProductEntity.price} />
                            <input type='button' readOnly value={item.ProductEntity.price} />
                            <input type='button' readOnly value={item.ProductEntity.unit} />
                            <input type='button' readOnly onClick={()=> this.handleClick(item.id)} value="删除"/>
                        </div>
                    })
                }
            </div>
        );
    }
}

export default Products;
