package br.com.vector.leandro.jogo.tree;

public enum MensagemEnum {
	
	PENSE_EM_UM_ANIMAL("Pense em um animal. "),
	O_ANIMAL_QUE_VOCE_PENSEOU_EH ("O animal que você pensou é "),
	QUAL_ANIMAL_VOCE_PENSOU ("Qual animal você pensou ?"),
	PERGUNTA_CARACTERISTICA("O animal que você pensou "),
	PERGUNTA_NOVA_CARACTERISTICA("Um(a) XXXX _____ mas o yyyy não ");
	
	
	private String msg;
	
	MensagemEnum(String msg)
	{
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
