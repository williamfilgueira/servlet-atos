/**
 * 
 */function validar() {

	let nome = frmFornecedor.nome.value
	let cnpj = frmFornecedor.cnpj.value
	let fone = frmFornecedor.fone.value
	let cep = frmFornecedor.cep.value
	let rua = frmFornecedor.rua.value
	let numero = frmFornecedor.numero.value


	if (nome === "") {
		alert("Entre com o nome")
		frmFornecedor.nome.focus()
		return false
	} else if (fone === "") {
		alert("Entre com o telefone")
		frmFornecedor.fone.focus()
		return false
	} else if (cnpj === "") {
		alert("Entre com o cnpj!")
		frmFornecedor.cnpj.focus()
		return false
	} else if (cep === "") {
		alert("Entre com o cep!")
		frmFornecedor.cep.focus()
		return false
	} else if (rua === "") {
		alert("Entre com o nome da rua!")
		frmFornecedor.rua.focus()
		return false
	} else if (numero === "") {
		alert("Entre com o núumero da rua!")
		frmFornecedor.numero.focus()
		return false
	}
	document.forms["frmFornecedor"].submit()
}

