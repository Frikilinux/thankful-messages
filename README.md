# Mensajes de gratitud API

Documentación disponible e Swagger `/swagger-ui/index.html`

## Uso de la api

### Crear un mensaje

`POST` /messages

#### Request

##### **_`Body`_**

```json
{
  "message": "Gracias totales.", // requerido
  "author": "Gustavo Ceratti" // requerido
}
```

#### Response

##### **_`201 Created`_**

```json
{
  "id": 1,
  "message": "Gracias totales.",
  "author": "Gustavo Ceratti",
  "createdAt": "2024-11-17T11:59:01",
  "popularity": 0
}
```

## Deploy y test en OCI

Clona este repositorio en una instancia en OCI

```sh
git clone https://github.com/Frikilinux/thankful-messages.git
cd thankful-messages
```

Copia el `env.example` a `.env`

```sh
cp env.example .env
```

Edita las variables si lo crees conveniente.

> [!IMPORTANT]
> Verifica que tengas docker instalado y ejecutandose.

Crea la imagen y inicia el contenedor

```sh
sudo docker compose --verbose up --build
```

La api estará disponible en el puerto especificado en el archivo `.env`

> [!IMPORTANT]
> Abre el puerto de la api desde la plataforma OCI y en el OS de la instancia.
