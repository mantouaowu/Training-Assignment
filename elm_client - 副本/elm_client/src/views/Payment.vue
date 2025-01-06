<template>
  <div class="wrapper">
    <!--  header-->
    <header>
      <p>在线支付</p>
    </header>
    <!--订单信息-->
    <h3>订单信息：</h3>
    <div class="order-info">
      <p>
        万家饺子（软件园E18店）
        <i class="fa fa-caret-down" id="showBtn"></i>
      </p>
      <p>&#165;34</p>
    </div>
    <!--    订单明细  -->
    <ul class="order-detailed" id="detailedBox">
      <li>
        <p>纯肉鲜肉（水饺） x 2</p>
        <p>&#165;15</p>
      </li>
      <li>
        <p>玉米鲜肉（水饺） x 1</p>
        <p>&#165;16</p>
      </li>
      <li>
        <p>配送费</p>
        <p>&#165;3</p>
      </li>
    </ul>
    <!--  支付方式部分    -->
    <ul class="payment-type">
      <li>
        <img src="../assets/alipay.png" >

      </li>
      <li>
        <img src="../assets/wechat.png" >
        <i class="fa fa-check-circle"></i>
      </li>
    </ul>
    <div class="payment-button">
      <router-link to="/Index">
      <button>确认支付</button>
      </router-link>
    </div>
			
			 <!-- 底部菜单部分 -->
	        <Footer></Footer>
		</div>	
</template>
<script>
import Footer from '../components/Footer.vue'
export default {
	components:{
		Footer
	}
	
}
</script>
<style scoped>
/*  总容器*/
.wrapper{
  width: 100%;
  height: 100%;
}

/* header部分 */
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #0997FF;
  color: #fff;
  font-size: 4.8vw;
  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;
  display: flex;
  justify-content: center;
  align-items: center;
}

/*<!--    订单信息部分-->*/
.wrapper h3{
  box-sizing: border-box;
  margin-top: 12vw;

  padding: 4vw 4vw 0;
  font-size: 4vw;
  font-weight: 300;
  color: #999;
}
.wrapper .order-info{
  box-sizing: border-box;
  padding: 4vw;
  font-size: 4vw;
  color: #666;
  display: flex;
  justify-content:space-between;
  align-items: center;
}
.wrapper .order-info p:last-child{
  color:orangered ;
}
/******************订单明细部分******************/
.wrapper  .order-detailed{
  width: 100%;

}
.wrapper  .order-detailed li{
  width: 100%;
  box-sizing: border-box;
  padding: 1vw 4vw;
  display: flex;
  justify-content: space-between;
  align-items: center;

}
.wrapper  .order-detailed li p{
  font-size:3vw ;
  color: #666;
}
/******************支付方式部分******************/
.wrapper .payment-type{
  width: 100%;

}
.wrapper .payment-type li{
  width: 100%;
  box-sizing: border-box;
  padding: 4vw;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.wrapper .payment-type li img{
  width: 33vw;
  height:8.9vw ;
}
.wrapper .payment-type li .fa-check-circle{
  font-size: 5vw;
  color: #38CA73;
}
/******************按钮部分******************/
.wrapper .payment-button{
  width: 100%;
  box-sizing: border-box;
  padding: 4vw;

}
.wrapper .payment-button button{
  width: 100%;
  height: 10vw;
  border: none;
  /**********将外轮廓线去掉**********/
  outline: none;
  border-radius: 4px;
  background-color: #38CA73;
  font-size: 5vw;
  color:#fff ;
}

</style>