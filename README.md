# Mensajes de gratitud API

La API de mensajes de gratitud permite a los usuarios crear, listar y votar mensajes de gratitud. Los mensajes de gratitud son una forma de expresar agradecimiento y positividad dentro de una comunidad como la **AlumniONE**.


![API image](https://ik.imagekit.io/zotta/github/180shots_so.webp?updatedAt=1731890178031)

## Documentación y testeo

Disponible en Swagger `/swagger-ui/index.html`

## Uso de la api

### Crear un mensaje

**`POST`** `/messages`

#### Request

##### **_`Body`_**

```JSON5
{
  "message": "Gracias totales.", // requerido
  "author": "Gustavo Ceratti" // requerido
}
```

#### Response

##### **_`201 Created`_**

```JSON5
{
  "id": 1,
  "message": "Gracias totales.",
  "author": "Gustavo Ceratti",
  "createdAt": "2024-11-17T11:59:01",
  "popularity": 0
}
```

### Obtener un mensaje por ID

**`GET`** `/messages/{id}`

#### Response

##### **_`200 OK`_**

```JSON5
{
  "id": 1,
  "message": "Gracias totales.",
  "author": "Gustavo Ceratti",
  "createdAt": "2024-11-17T11:59:01",
  "popularity": 1
}
```

### Obtener todos los mensajes

**`GET`** `/messages`

#### Response

##### **_`200 OK`_**

```JSON5
{
  "content": [
    {
      "id": 1,
      "message": "Gracias totales.",
      "author": "Gustavo Ceratti",
      "createdAt": "2024-11-17T11:59:01",
      "popularity": 0
    },
    {
      "id": 2,
      "message": "Dar las gracias por lo que uno tiene; acabará teniendo más. Si te concentras en lo que no tienes, nunca tendrás suficiente.",
      "author": "Oprah Winfrey",
      "createdAt": "2024-11-17T23:09:54",
      "popularity": 0
    },
    {
      "id": 3,
      "message": "Agradecer a alguien por algo es reconocer una bondad en ti mismo.",
      "author": "Alan Cohen",
      "createdAt": "2024-11-17T23:10:40",
      "popularity": 0
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 1,
  "totalPages": 1,
  "last": true,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```

### Paramentros de ordenamiento y paginación

| Parametro | Valor por defecto | Descripción                               |
| --------- | ----------------- | ----------------------------------------- |
| sort      | id,ASC            | Ordena los registros \<clave>,<dirección> |
| size      | 20                | Limite de registros obtenidos por página  |
| page      | 0                 | Indice de página a obtener desde 0        |

> [!NOTE]
> Por defecto, en esta api, se obtinen lo mensajes ordenados por `id` de forma ascendente y paginados de 20 registros por consulta.

#### Odenar mensajes por fecha de creación descendente

**`GET`** `/messages?sort=createdAt,DESC`

#### Odenar mensajes por polaridad de creación de forma descendente

**`GET`** `/messages?sort=popularity,DESC`

#### Odenar mensajes paginados de a 30 y ordenados por autor de forma ascendente

**`GET`** `/messages?sort=autor,ASC&size=30`

### Votar un mensaje

**`PUT`** `/messages/{id}/upvote`

#### Response

##### **_`200 OK`_**

```JSON5
{
  "id": 1,
  "message": "Gracias totales.",
  "author": "Gustavo Ceratti",
  "createdAt": "2024-11-17T11:59:01",
  "popularity": 1
}
```

### Elimina un mensaje

`DELETE` `/messages/{id}`

#### Response

##### **_`200 OK`_**

```JSON5
Mensaje eliminado.
```

---

## Deploy y test en OCI

Clona este repositorio en una instancia en OCI

```Shell
git clone https://github.com/Frikilinux/thankful-messages.git
cd thankful-messages
```

Copia el `env.example` a `.env`

```Shell
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

---

## Demo

Puede encontrarce una demo de esta api sólo para propósitos educativos en: 

**`https://thankful.zotta.dev/`**
