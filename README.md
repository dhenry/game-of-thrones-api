# game-of-thrones-api

Persists some of the Game of Thrones board game state.

## Endpoints

### GET /state || /newGame

```javascript
{
    availableRoundOneCards: [{
        id: 0,
        title: "A Throne of Blades",
        incrementsWildlings: true,
        shuffleDeck: false
    }],
    availableRoundTwoCards: [{
        id: 0,
        title: "Dark Wings, Dark Words",
        incrementsWildlings: true,
        shuffleDeck: false
    }],
    availableRoundThreeCards: [{
        id: 0,
        title: "Put to the Sword",
        incrementsWildlings: false,
        shuffleDeck: false
    }],
    wildlingsStrength: 0
}
```
### GET /roundOneCard || /roundTwoCard || /roundThreeCard 

```javascript
{
    id: 5,
    title: "Feast for Crows",
    incrementsWildlings: true,
    shuffleDeck: false
}
```

### GET /wildlings

```javascript
0 - 12
```

### GET /battleWildlings?won=true||false

```javascript
0 - 12
```