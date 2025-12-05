# 💰 Expense Tracker CLI

Um utilitário de linha de comando (CLI) escrito em Java para gerenciar suas despesas pessoais diretamente no terminal. Simples, rápido e eficiente para controle financeiro diário.

## 🚀 Funcionalidades

- ✅ **Adicionar despesas** com descrição e valor
- ✅ **Listar todas as despesas** em formato tabular
- ✅ **Atualizar despesas** existentes (descrição e/ou valor)
- ✅ **Excluir despesas** por ID
- ✅ **Visualizar resumo** total de gastos
- ✅ **Filtrar por mês** para análise mensal
- ✅ **Validação robusta** de entradas (valores negativos, campos vazios)
- ✅ **Interface intuitiva** via linha de comando

## 📦 Estrutura do Projeto

```
expense-tracker/
├── src/
│   ├── Expense.java           # Modelo de dados da despesa
│   ├── ExpenseManager.java    # Lógica de negócio (CRUD)
│   └── ExpenseTrackerCLI.java # Interface de linha de comando
├── README.md                  # Este arquivo
└── compile_run.bat            # Script para compilar e executar (Windows)
```

## 🛠️ Pré-requisitos

- **Java JDK 8 ou superior**
- **Terminal/Command Prompt** básico

## ⚡ Instalação e Execução

### 1. Clone ou baixe o projeto
```bash
git clone https://github.com/seu-usuario/expense-tracker.git
cd expense-tracker/src
```

### 2. Compilação
```bash
# Compile todas as classes
javac *.java
```

### 3. Execução
```bash
# Formato geral
java ExpenseTrackerCLI <comando> [argumentos]
```

## 📖 Como Usar

### Adicionar uma Despesa
```bash
java ExpenseTrackerCLI add --description "Almoço" --amount 25.50
# Saída: Expense added
```

### Listar Todas as Despesas
```bash
java ExpenseTrackerCLI list
# Saída:
# ID  Date       Description  Amount
# -----------------------------------
# 1   2024-08-06  Almoço       $25.50
# 2   2024-08-06  Transporte   $10.00
```

### Atualizar uma Despesa
```bash
# Atualizar ambos os campos
java ExpenseTrackerCLI update --id 1 --description "Almoço Executivo" --amount 35.00

# Atualizar apenas descrição
java ExpenseTrackerCLI update --id 1 --description "Jantar"

# Atualizar apenas valor
java ExpenseTrackerCLI update --id 1 --amount 40.00
# Saída: Expense updated
```

### Excluir uma Despesa
```bash
java ExpenseTrackerCLI delete --id 2
# Saída: Expense deleted
```

### Visualizar Resumo
```bash
# Resumo geral
java ExpenseTrackerCLI summary
# Saída: Total expenses: $65.50 (2 expenses)

# Resumo por mês
java ExpenseTrackerCLI summary --month 8
# Saída: Total expenses for August: $65.50 (2 expenses)
```

### Ajuda
```bash
java ExpenseTrackerCLI
# Saída:
# Uso: expense-tracker <command>
# Commands: add, list, delete, update, summary
```

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas simples:

1. **Expense.java** - Camada de Modelo (Entity)
   - Representa uma despesa individual
   - Validações de integridade dos dados
   - Getters e setters controlados

2. **ExpenseManager.java** - Camada de Serviço (Business Logic)
   - Gerencia a coleção de despesas
   - Implementa operações CRUD
   - Geração automática de IDs

3. **ExpenseTrackerCLI.java** - Camada de Apresentação (CLI)
   - Interface com o usuário
   - Parser de argumentos de linha de comando
   - Formatação de saída

## 🔒 Validações Implementadas

- **IDs**: Não podem ser nulos ou negativos
- **Descrições**: Não podem ser nulas ou vazias
- **Valores**: Não podem ser nulos ou negativos
- **Meses**: Devem estar entre 1 e 12
- **Argumentos**: Verificação de argumentos faltando

## 🧪 Casos de Uso de Exemplo

```bash
# Fluxo completo de uso
java ExpenseTrackerCLI add --description "Supermercado" --amount 150.75
java ExpenseTrackerCLI add --description "Cinema" --amount 40.00
java ExpenseTrackerCLI add --description "Uber" --amount 25.30

java ExpenseTrackerCLI list

java ExpenseTrackerCLI update --id 2 --description "Cinema IMAX" --amount 50.00

java ExpenseTrackerCLI summary
# Saída: Total expenses: $226.05 (3 expenses)

java ExpenseTrackerCLI delete --id 3

java ExpenseTrackerCLI summary --month 8
# Saída: Total expenses for August: $200.75 (2 expenses)
```

## ⚠️ Limitações Atuais

- **Persistência**: As despesas são mantidas apenas em memória (perdidas ao fechar o programa)
- **Multi-usuário**: Suporte single-user apenas
- **Categorização**: Sem categorias para organizar despesas
- **Exportação**: Não exporta para CSV/PDF

## 🧠 Conceitos Aprendidos com Este Projeto

- **Programação Orientada a Objetos** em Java
- **Design de Classes** com responsabilidades bem definidas
- **Validação de Dados** e tratamento de exceções
- **Parsing de Argumentos** de linha de comando
- **Manipulação de Datas** com `LocalDate`
- **Uso de Streams API** e `Optional` para código mais limpo
- **Encapsulamento** e cópias defensivas
- **Formatação de Saída** com `printf`

## 📝 Boas Práticas Implementadas

1. **Separação de Responsabilidades**: Cada classe tem uma única responsabilidade
2. **Validação Fail-Fast**: Erros são detectados o mais cedo possível
3. **Imutabilidade Parcial**: IDs e datas não podem ser alterados após criação
4. **Feedback ao Usuário**: Mensagens claras de sucesso/erro
5. **Código Limpo**: Nomes descritivos, métodos curtos, baixo acoplamento

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.

## 👨‍💻 Autor

Este projeto foi baseado no desafio https://roadmap.sh/projects/expense-tracker

Desenvolvido como projeto educativo para demonstrar:
- Desenvolvimento de ferramentas CLI em Java
- Princípios de design orientado a objetos
- Boas práticas de validação e tratamento de erros
- Estruturação de projetos Java simples
