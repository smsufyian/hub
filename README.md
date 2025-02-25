# Hub Project

## Git Hooks Setup

This project uses Git hooks to ensure code quality. Currently, we have the following hooks:

### Pre-commit Hook
The pre-commit hook runs all tests before allowing a commit to proceed. This helps prevent committing code that breaks the test suite.

### Pre-push Hook
The pre-push hook runs all tests before allowing a push to proceed. This provides an additional layer of protection against pushing code that breaks the test suite.

To set up the hooks:

1. Configure Git to use the custom hooks directory:
```bash
git config core.hooksPath .githooks
```

2. Ensure the hook scripts are executable:
```bash
chmod +x .githooks/pre-push
```

Now, whenever you try to push changes, the tests will run automatically. The push will be blocked if any tests fail.

### Troubleshooting

If the pre-push hook isn't running:
1. Verify that Git is using the correct hooks path:
```bash
git config --get core.hooksPath
```
2. Check that the pre-push script is executable:
```bash
ls -l .githooks/pre-push
```
3. You can test the hook manually by running:
```bash
.githooks/pre-push
```

## CI/CD and Cloud Deployment

This project uses GitHub Actions for continuous integration and automated deployment to Google Cloud Run.

### Automatic Deployment

When code is pushed to the main branch, the CI workflow automatically:
1. Builds the project
2. Runs all tests
3. Builds a Docker image
4. Pushes the image to Google Container Registry
5. Deploys the application to Google Cloud Run

The version is managed in `app/build.gradle.kts`. To update the version:
1. Modify the `version = "X.Y.Z"` in the build file
2. Commit and push to main
3. A new version will be automatically deployed

### Required Secrets

The following secrets need to be configured in your GitHub repository:

1. `GCP_PROJECT_ID`: Your Google Cloud Project ID
2. `GCP_SA_KEY`: The JSON key of a service account with the following permissions:
   - Storage Admin (for pushing to Container Registry)
   - Cloud Run Admin
   - Service Account User

To set up the secrets:
1. Go to your repository's Settings
2. Navigate to Secrets and Variables > Actions
3. Add the required secrets

The application will be deployed to Cloud Run in the asia-southeast1 region and will be publicly accessible.
