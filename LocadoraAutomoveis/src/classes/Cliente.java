package classes;

public class Cliente {

        private String nome;
        private String sobrenome;
        private String rg;
        private String cpf;
        private String endereco;
        private int idcliente;
        

        public Cliente(String nome, String sobrenome, String rg, String cpf, String endereco) {
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.rg = rg;
                this.cpf = cpf;
                this.endereco = endereco;
        }
        
        public Cliente(){}

        public int getIdcliente() {
                return idcliente;
        }

        public void setIdcliente(int idcliente) {
                this.idcliente = idcliente;
        }

        
        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getSobrenome() {
                return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
                this.sobrenome = sobrenome;
        }

        public String getRg() {
                return rg;
        }

        public void setRg(String rg) {
                this.rg = rg;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public String getEndereco() {
                return endereco;
        }

        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }

}
