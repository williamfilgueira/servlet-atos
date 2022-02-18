/**
 * 
 */function validar() {

	let nome = frmCliente.nome.value
	let cpf = frmCliente.cpf.value
	let fone = frmCliente.fone.value
	let cep = frmCliente.cep.value
	let rua = frmCliente.rua.value
	let numero = frmCliente.numero.value


	if (nome === "") {
		alert("Entre com o nome")
		frmCliente.nome.focus()
		return false
	} else if (fone === "") {
		alert("Entre com o telefone")
		frmCliente.fone.focus()
		return false
	} else if (cpf === "") {
		alert("Entre com o cpf!")
		frmCliente.cpf.focus()
		return false
	} else if (cep === "") {
		alert("Entre com o cep!")
		frmCliente.cep.focus()
		return false
	} else if (rua === "") {
		alert("Entre com o nome da rua!")
		frmCliente.rua.focus()
		return false
	} else if (numero === "") {
		alert("Entre com o núumero da rua!")
		frmCliente.numero.focus()
		return false
	}
	document.forms["frmCliente"].submit()
}

