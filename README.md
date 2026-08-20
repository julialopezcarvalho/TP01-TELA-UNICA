# AppTelaUnica — Atividade 01 (Kotlin + XML)

Projeto Android Studio com **3 módulos**, um para cada exercício da atividade:

| Módulo  | App                        | Exercício |
|---------|----------------------------|-----------|
| `app01` | Cadastro / Boas-vindas     | Nome + idade → mensagem de boas-vindas |
| `app02` | Conversor de Temperatura   | Celsius → Fahrenheit |
| `app03` | 1ª Lei de Ohm              | V = R × I (calcula a grandeza que faltar) |

## Como abrir

1. Descompacte a pasta `AppTelaUnica`.
2. No Android Studio: **File → Open…** e selecione a pasta `AppTelaUnica`
   (a que contém o `settings.gradle.kts`) — **não** abra um módulo isolado.
3. Aguarde o *Gradle Sync*. Na primeira vez ele baixa o Gradle 8.9 e as
   dependências (precisa de internet).
4. Se aparecer aviso de SDK faltando, clique em **Install missing SDK package(s)**.

## Como rodar cada app

Na barra superior, ao lado do botão ▶, abra o seletor de configuração e escolha
`app01`, `app02` ou `app03`. Cada módulo instala como um aplicativo independente
no emulador.

## Configuração usada

- Gradle 8.9 · Android Gradle Plugin 8.7.3 · Kotlin 2.0.21
- `compileSdk` / `targetSdk` = 35 · `minSdk` = 24
- Java 17 (Android Studio já vem com o JBR 17+)
- Views + XML (sem Jetpack Compose), `AppCompatActivity` e `findViewById`

## Onde está o código

```
app0X/src/main/java/com/example/app0X/MainActivity.kt   <- lógica
app0X/src/main/res/layout/activity_main.xml             <- tela
```

## Possíveis ajustes

- **Android Studio pede para atualizar o AGP**: pode aceitar (*Upgrade Assistant*),
  o código não muda.
- **Erro de `local.properties`**: o arquivo é gerado automaticamente pelo Studio
  com o caminho do seu Android SDK; por isso ele não vem no zip.
- **Trocar `findViewById` por View Binding**: adicione em `app0X/build.gradle.kts`,
  dentro de `android { }`:

  ```kotlin
  buildFeatures {
      viewBinding = true
  }
  ```
