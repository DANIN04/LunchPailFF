from balldontlie import BalldontlieAPI

api = BalldontlieAPI(api_key="a34a3979-5e35-4ff3-a105-7e5799cef4e0")

teams = api.nfl.teams.list()

print("List of NFL Teams:")
print(teams)