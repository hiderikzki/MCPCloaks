# MCPCloaks
A custom multi cape modification for MCP (Better than Cloaks+) 

# To Be Added
- Animated Cape Support
- More Features

# Setup
Download the source and follow the instructions under

# Main Client Class
Add a cape location:

```Java
public static final String CAPE_LOC = "Desired/Location/For/Capes"; // Working directory should be set to jars, so for example a proper location would be ClientName/Capes
```

Add a cape loader:

```Java
public static final CapeLoader capeLoader = new CapeLoader();
```

Add a custom texture binder:

```Java
public static final SimpleTextureBinder cape = new SimpleTextureBinder();
```

Add Cape Loading And Directory Creation:

```Java
try
{
  capeLoader.createCapeDirectoryIfNotExists(CAPE_LOC);
  capeLoader.loadCapesFromLocation(CAPE_LOC);
}
catch (IOException e)
{
  e.printStackTrace();
}
```

# LayerCape Class
Remove a check from the if statement in doRenderLayer() function:

```Java
entitylivingbaseIn.getLocationCape() != null
```

Replace texture binding function with a new texture binding function:

```Java
RenderCape.renderCurrentCape(entitylivingbaseIn, playerRenderer);
```

# GuiMainMenu Class
Add a gui button in addSingleplayerMultiplayerButtons function:

```Java
this.buttonList.add(new GuiButton(1337, 5, 5, 120, 20, "Cape Switcher"));
```

Add functionality to the button in actionPerformed function:

```Java
if(button.id == 1337)
{
  this.mc.displayGuiScreen(new CapeSelectorGui(this));
}
```

# GuiIngameMenu Class
Add a gui button in initGui function:

```Java
this.buttonList.add(new GuiButton(69, 5, this.height - 25, 120, 20, "Cape Switcher"));
```

Add functionality to the button in actionPerformed function:

```Java
if(button.id == 1337)
{
  this.mc.displayGuiScreen(new CapeSelectorGui(this));
}
```
