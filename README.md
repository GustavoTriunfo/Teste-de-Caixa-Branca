# Exercício individual - Teste de Caixa Branca (ETAPA 1)

## Erros apontados:

1) Erro no Nome da Classe do Driver MySQL:
No método conectarBD(), há um erro no nome da classe do driver MySQL. Deve ser corrigido de "com.mysql.Driver.Manager" para "com.mysql.jdbc.Driver".
```java
  public Connection conectarBD() {
	Connection conn = null;
	try {
		Class.forName("com.mysql.Driver.Manager").newInstance();
```

2) Falta de Tratamento de Exceções Adequado:
O código atualmente captura exceções, mas não faz nada com elas. Isso é um problema. Deve haver um tratamento adequado de exceções, como registrar ou relatar os erros, para que possam ser diagnosticados e corrigidos.
```java
}catch (Exception e) {}
```

3) Concatenação Direta de Strings em Consultas SQL:
A construção de consultas SQL concatenando diretamente os valores de entrada (login e senha) no SQL é vulnerável a ataques de injeção de SQL. É uma prática insegura. Em vez disso, consultas parametrizadas ou preparadas devem ser usadas para evitar esse tipo de vulnerabilidade.
```java
public boolean verificarUsuario(String login, String senha) {
		String sql = "";
		Connection conn = conectarBD();
		//INSTRUÇÃO SQL
		sql += "select nome from usuarios ";
		sql += "where login = " + "'" + login + "'";
		sql += " and senha = " + "'" + senha + "';";
```

4) Má Prática de Acesso às Variáveis de Classe:
As variáveis de classe nome e result estão declaradas como públicas, violando os princípios de encapsulamento. Deve-se usar métodos getters e setters para acessar essas variáveis, se necessário.
```java
public String nome = "";
public boolean result = false;
```

5) Fechamento Inadequado de Conexões:
O código não fecha explicitamente as conexões com o banco de dados após o uso. Isso pode levar a vazamentos de recursos. Deve haver um tratamento adequado de fechamento de conexões, declarações e resultados.
```java
  conn = DriverManager.getConnection(url);
//falta fechar a conexão posteriormente no código
```

6) Senha em Texto Puro:
O código passa a senha como texto puro, o que não é seguro. As senhas devem ser armazenadas com hash e salvas no banco de dados, e a comparação deve ser feita com base no hash.
```java
        public boolean verificarUsuario(String login, String senha) {
		String sql = "";
		Connection conn = conectarBD();
		//INSTRUÇÃO SQL
		sql += "select nome from usuarios ";
		sql += "where login = " + "'" + login + "'";
		sql += " and senha = " + "'" + senha + "';";
```

7) Nomenclatura de Variáveis Pouco Descritiva:
As variáveis login e senha usadas na função verificarUsuario() poderiam ter nomes mais descritivos para melhorar a legibilidade do código.
```java
  public boolean verificarUsuario(String login, String senha) {
```

8) Falta de Documentação e Comentários:
O código não contém documentação ou comentários explicativos para ajudar outros desenvolvedores a entender seu funcionamento. Isso dificulta a manutenção e colaboração no código.

9) Problemas de Legibilidade e Organização:
O código poderia ser mais legível com recuos e espaçamento adequados. Além disso, seguir as convenções de nomenclatura do Java tornaria o código mais organizado.

10) Má Prática de Tratamento de Booleanos:
O uso de uma variável result como uma flag para verificar se o usuário existe não é a melhor abordagem. Pode ser mais limpo e seguro retornar um valor booleano diretamente da função verificarUsuario().
```java
ResultSet rs = st.executeQuery(sql);
if(rs.next()) {
result = true;
nome = rs.getString("nome");}
```
# Exercício individual - Teste de Caixa Branca (ETAPA 2)

## Grafo de Fluxo identificado:
<a href="https://ibb.co/phVbGMj"><img src="https://i.ibb.co/9ZKcz1H/Fluxo-de-Grafo.png" alt="Fluxo-de-Grafo" border="0"></a>

## Cálculo da complexidade ciclomática:

Calculamos o número de nós de controle (p):

p = 10 (nós de controle, excluindo o nó de início e fim)

Finalmente, calculamos a complexidade ciclomática usando a fórmula V(G) = p + 1:

V(G) = 10 + 1 = 11

Portanto, a complexidade ciclomática do código é 11.

## Sequências:

- Sequência sem exceção:
1, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17

- Exceção lançada no nó 2 (Class.forName):
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17

- Exceção lançada no nó 9 (try após sql):
1, 2, 3, 6, 7, 8, 9, 10, 15, 16, 17

- Exceção lançada no nó 11 (if após rs.next()):
1, 2, 3, 6, 7, 8, 9, 10, 11, 15, 16, 17

- Exceção lançada no nó 13 (if dentro do bloco if):
1, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17

# Exercício individual - Teste de Caixa Branca (ETAPA 3)

## Documentação:

Na branch ETAPA_3 é desenvolvida a documentação do código da classe User. Acesse a branch especificada para visualizar os detalhes do código. 
Utilizei a marcação /****/ para efetuar o comentário de documentação, e posteriormente , na IDE Eclipse, acessei o menu "Project" e gerei o Javadoc.
A pasta javadoc está na branch ETAPA_3, antes da pasta src. Denominada como "doc".
<br><br>
Nessa atividade foi gerada a documentação que antes estava pendente nesse projeto. Todas as áreas de método, variáveis criadas e momentos considerados cruciais foram devidamente documentados. 
Vale acrescentar que mesmo áreas de Exception do bloco catch onde deveria ter um tratamento foi explicado o tipo de exceção que deveria ser tratada e que aquilo representa uma prática não recomendada.
<br><br>
Estou aberto a feedbacks. Caso hajam sugestões entre em contato.

## Última atualização: 08/10/2023
