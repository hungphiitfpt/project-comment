var baseURL = `http://localhost:8080`;
var typeid = $("#select-product").val();
var keyName = $('.name-product-input').val();
var keyDes = $('.description-product-input').val();
$(function() {
	loadAllCategory();
})
$(".btn-search").click(function() {
	loadAllProduct()
});
function loadAllCategory() {
	axios.get(`${baseURL}/loadAllCategory`)
		.then(function(response) {
			console.log(response.data)
			DrawDatacombobox(response.data)
		})
		.catch(function(error) {
			console.log(error);
		});
}
function firstPage() {
	console.log(typeid,keyName,keyDes)
	axios.get(`${baseURL}/find/panigation?page=0&size=5&name&description&typeid=`)
		.then(function(response) {
			DrawDatatable(response.data)
		})
		.catch(function(error) {
			console.log(error);
		});
}
function lastPage() {
	console.log(typeid,keyName,keyDes)
	axios.get(`${baseURL}/find/panigation?page=1&size=5&name=${keyName}&description=${keyDes}&typeid=${typeid}`)
		.then(function(response) {
			DrawDatatable(response.data)
		})
		.catch(function(error) {
			console.log(error);
		});
}
function loadAllProduct() {
let typeid = $("#select-product").val();
let keyName = $('.name-product-input').val();
let keyDes = $('.description-product-input').val();
	axios.get(`${baseURL}/find/panigation?page=0&size=5&name=${keyName}&description=${keyDes}&typeid=${typeid}`)
		.then(function(response) {
			DrawDatatable(response.data)
		})
		.catch(function(error) {
			console.log(error);
		});
}
function DrawDatatable(response) {
	let res = response;
	console.log(response)
	console.log(123213213)
	if (response.length == []) {
		alert("Không tồn tại sản phẩm thỏa điều kiện search");
	}
	$('.body-table-product-list tr').remove();
	for (let i = 0; i < res.length; i++) {
		$('.body-table-product-list').append(`<tr class="row-product">
	<td>${i}</td>
	<td><img src="${baseURL}/api/v1/FileUpload/files/${res[i].productImg}" class="image-product-item" alt=""></td>
	<td>
		<div class="row flex-column">
			<div class="code-product-item">${res[i].productId}</div>
			<div class="row">
				<div class="name-product-item ml-3">${res[i].productName}</div>
				&nbsp; SL:<label class="product-amount ml-3" for="">${res[i].productAmount}</label>
			</div>
		</div>
	</td>
	<td>${res[i].productType.productTypeName}</td>
	<td class=""> 
		<div class="row flex-column">
			<div class="code-product-item">Model: 0001232</div>
			<div class="row">
				<p class="ml-3 description-product-item">${res[i].productDescription}</p>
			</div>
		</div> 
	</td>
	<td class="column-quantity"><input onblur="validateQuantity($(this))"
		class="quantity-product-item" type="number"></td>
</tr>`)
	} 
}
function DrawDatacombobox(response) {
	for (let i = 0; i < response.length; i++) {
		$('#select-product').append(`<option value="${response[i].productTypeId}">${response[i].productTypeName}</option>`)
	} 
}     
let cart = [];
async function validateQuantity(key) {
	value = parseInt(key.val());
	console.log(value);
	console.log(Number.isInteger(value))
	let  a = key.parents('.column-quantity').parents('.row-product').find('.code-id-product').text();  
	let amountProduct = key.parents('.column-quantity').parents('.row-product').find('.product-amount').text();  
	console.log(a);
	console.log('amount',amountProduct);
	console.log(value)
	numberInterger = /^\d+$/
	if(numberInterger.test(value)){
		let storage = localStorage.getItem('cart');
		
		if(storage){
			cart = JSON.parse(storage)
		}
		let item = cart.find(c => c.id == a)
		console.log(item)
		if(item){
			item.quantity += value
			if(item.quantity > parseInt(amountProduct)){
				alert('Số lượng đặt hàng của sản phẩm không đủ trong kho. Xin hãy nhập số lượng <= số lượng đang tồn tại trong đó');
				key.parents('.column-quantity').find('input').val(0)
				return false;
			}
		}
		else{
		    cart.push({id : a, quantity: value})
		}
	} else{ 
		alert("Số lượng đặt hàng không hợp lệ, xin hãy nhập lại")
		return false;
	}
}
function addToCart() {
	alert('đã thêm vào local storage')
	console.log(cart)
	localStorage.setItem('cart',JSON.stringify(cart))
}
$('.btn-order').on('click',async function () {
	await addToCart() ;
	window.location.href = `${baseURL}/buyCart`;
})
$('.btn-cancel').on('click', function () {
	
	window.location.href = `${baseURL}/getAllProduct`;
})

