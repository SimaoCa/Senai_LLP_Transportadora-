# Senai_LLP_Transportadora

## Descrição
Sistema de cálculo de frete desenvolvido em Java utilizando os 
princípios de Programação Orientada a Objetos (POO). A aplicação 
simula uma transportadora que opera com três modais de transporte 
— rodoviário, aéreo e fluvial — e calcula o custo do frete com 
base no peso, dimensões e distância da encomenda.

## Hierarquia de Classes
- **Veiculo** (abstrata) → base de toda a hierarquia
  - **VeiculoTerrestre** → **Caminhao**
  - **VeiculoAereo** → **Aviao**
  - **VeiculoFluvial** → **PortaContainer**

## Interface
- **Transporte**: contrato com o método `calcularFrete(peso, altura, largura, distancia)`

## Fórmulas de Cálculo
| Modal | Fórmula |
|---|---|
| Caminhão | `(peso + altura × largura) × (distância × R$6,99)` |
| Avião | `(peso² × altura × largura) × (distância × R$9,99)` |
| Porta-Container | `peso + (altura × largura) × distância` |

## Tecnologias
- Java 25
- IntelliJ IDEA
- POO: Herança, Abstração, Polimorfismo e Interface
